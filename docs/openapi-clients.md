# OpenAPI 客户端发布与使用

Entloom 的 OpenAPI 契约由 Springdoc 从服务端 Controller 自动生成。运行中的契约地址是：

```text
http://localhost:8080/api/v1/openapi.yaml
```

仓库同时保存一份可审阅、可复现的契约快照：

```text
server/src/main/resources/openapi/entloom.yaml
```

JavaScript、Java 和 Python 客户端都从这份快照生成，并与服务端代码保持同一个 Git 提交和版本线。

## 客户端目录

| 客户端 | 目录 | 当前包版本 | 生成器 |
| --- | --- | --- | --- |
| JavaScript / TypeScript | `clients/javascript` | `0.1.0` | OpenAPI Generator 7.10.0 |
| Java | `clients/java` | `0.1.0` | OpenAPI Generator 7.10.0 |
| Python | `clients/python` | `0.1.0` | OpenAPI Generator 7.10.0 |

生成目录中的源文件由工具维护。不要直接修改生成文件；需要调整接口时，修改服务端契约、生成参数或生成脚本，再重新生成。

## 更新契约并生成客户端

先启动服务端，使 Springdoc 输出最新契约：

```bash
cd server
./mvnw spring-boot:run
```

在仓库根目录执行：

```bash
./scripts/refresh-openapi.sh
./scripts/generate-clients.sh
```

如果服务端不在默认地址，可以指定地址：

```bash
ENTLOOM_SERVER_URL=http://localhost:18080 ./scripts/refresh-openapi.sh
```

生成脚本会：

1. 下载并缓存固定版本的 OpenAPI Generator CLI。
2. 校验 OpenAPI 文档。
3. 清理三个客户端目录并重新生成。
4. 使用 `hideGenerationTimestamp=true` 保证输出可复现。

提交前检查：

```bash
git diff -- server/src/main/resources/openapi/entloom.yaml clients
```

CI 的 `openapi-clients` Job 会再次运行生成脚本，并执行 `git diff --exit-code -- clients`。如果契约快照与生成结果不同，构建会失败。

## JavaScript / TypeScript

构建本地客户端包：

```bash
cd clients/javascript
npm install
npm run build
npm pack
```

在 TypeScript 项目中使用：

```ts
import { Configuration, DefaultApi } from '@entloom/client';

const api = new DefaultApi(new Configuration({
  basePath: 'http://localhost:8080',
  username: process.env.ENTLOOM_USERNAME,
  password: process.env.ENTLOOM_PASSWORD,
}));

await api.apiV1AuthMeGet();
```

当前仓库先提供可审阅、可打包的客户端源码。发布到 npm 时，在 `clients/javascript` 目录执行：

```bash
npm publish --access public
```

发布前确认 `package.json` 的 `name`、`version`、`repository` 和 npm 登录状态。正式发布时，客户端版本应与 Entloom Git tag 对齐，例如 `0.2.0` 对应 `v0.2.0`。

## Java

构建 Java 客户端：

```bash
cd clients/java
mvn test
mvn package
```

使用 Spring `RestClient` 生成的客户端：

```java
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;

ApiClient client = new ApiClient();
client.setBasePath("http://localhost:8080");
client.setUsername(System.getenv("ENTLOOM_USERNAME"));
client.setPassword(System.getenv("ENTLOOM_PASSWORD"));

DefaultApi api = new DefaultApi(client);
api.apiV1AuthMeGet();
```

发布到 Maven 仓库前，需要在 `clients/java/pom.xml` 配置目标仓库的 `distributionManagement` 和凭据，然后执行：

```bash
mvn deploy
```

当前仓库不会把凭据写入源码。推荐通过 `~/.m2/settings.xml`、CI Secret 或 OIDC 配置发布认证。

## Python

构建 Python 包：

```bash
cd clients/python
python -m pip install --upgrade build
python -m build
```

使用客户端：

```python
import os
import entloom_client
from entloom_client.api.default_api import DefaultApi

configuration = entloom_client.Configuration(
    host="http://localhost:8080",
    username=os.environ["ENTLOOM_USERNAME"],
    password=os.environ["ENTLOOM_PASSWORD"],
)

with entloom_client.ApiClient(configuration) as api_client:
    api = DefaultApi(api_client)
    api.api_v1_auth_me_get()
```

发布到 PyPI 前，先配置可信发布或 `TWINE_USERNAME` / `TWINE_PASSWORD`，再执行：

```bash
python -m pip install --upgrade twine
python -m twine upload dist/*
```

## 版本与发布规则

一次 API 兼容变更应在同一个提交中包含：

- 服务端 Controller、DTO 或安全配置变更。
- `server/src/main/resources/openapi/entloom.yaml` 契约快照更新。
- `clients/javascript`、`clients/java`、`clients/python` 重新生成结果。
- 客户端包版本和根仓库 Git tag 更新。
- 使用示例或兼容性说明更新。

建议使用以下版本规则：

- 修复或文档变更：补丁版本，例如 `0.1.1`。
- 向后兼容的接口扩展：次版本，例如 `0.2.0`。
- 删除字段、改变必填参数或改变语义：主版本，例如 `1.0.0`。

当前 CI 负责契约有效性和生成一致性检查。推送形如 `v0.2.0` 的 Git tag 后，`Release clients` 工作流会自动构建 JavaScript、Java 和 Python 包，并把包文件与 `SHA256SUMS` 上传到 GitHub Release。

## GitHub Release 发布

发布前确认契约快照、三个客户端目录和版本号已经在同一个提交中更新，然后创建并推送版本 tag：

```bash
git tag v0.2.0
git push origin v0.2.0
```

工作流文件是 `.github/workflows/release-clients.yml`。它会生成：

- JavaScript npm tarball。
- Java Maven JAR。
- Python wheel 和 source distribution。
- `SHA256SUMS` 校验文件。

GitHub Release 是当前默认的分发渠道；npm、Maven Central 和 PyPI 的正式发布仍需要配置各自仓库的凭据与发布目标。
