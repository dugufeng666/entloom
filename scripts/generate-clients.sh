#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SPEC="${ROOT_DIR}/server/src/main/resources/openapi/entloom.yaml"
CACHE_DIR="${ROOT_DIR}/.cache"
GENERATOR_VERSION="${OPENAPI_GENERATOR_VERSION:-7.10.0}"
CLIENT_VERSION="${ENTLOOM_CLIENT_VERSION:-0.1.0}"
GENERATOR_JAR="${CACHE_DIR}/openapi-generator-cli-${GENERATOR_VERSION}.jar"
mkdir -p "${CACHE_DIR}"
if [[ ! -f "${GENERATOR_JAR}" ]]; then
  curl --fail --location --retry 3 "https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/${GENERATOR_VERSION}/openapi-generator-cli-${GENERATOR_VERSION}.jar" --output "${GENERATOR_JAR}"
fi

java -jar "${GENERATOR_JAR}" validate -i "${SPEC}"

rm -rf "${ROOT_DIR}/clients/javascript" "${ROOT_DIR}/clients/java" "${ROOT_DIR}/clients/python"
java -jar "${GENERATOR_JAR}" generate -i "${SPEC}" -g typescript-fetch -o "${ROOT_DIR}/clients/javascript" --additional-properties=supportsES6=true,npmName=@entloom/client,npmVersion="${CLIENT_VERSION}",hideGenerationTimestamp=true
java -jar "${GENERATOR_JAR}" generate -i "${SPEC}" -g java -o "${ROOT_DIR}/clients/java" --additional-properties=library=restclient,hideGenerationTimestamp=true,groupId=io.entloom,artifactId=entloom-client,artifactVersion="${CLIENT_VERSION}"
java -jar "${GENERATOR_JAR}" generate -i "${SPEC}" -g python -o "${ROOT_DIR}/clients/python" --additional-properties=packageName=entloom_client,projectName=entloom-client,packageVersion="${CLIENT_VERSION}",hideGenerationTimestamp=true

python3 - "${ROOT_DIR}" "${CLIENT_VERSION}" <<'PY'
import json
import sys
from pathlib import Path

root = Path(sys.argv[1])
version = sys.argv[2]
repository = "https://github.com/dugufeng666/entloom"

javascript = root / "clients/javascript/package.json"
package = json.loads(javascript.read_text())
package["version"] = version
package["description"] = "Entloom OpenAPI client"
package["repository"] = {"type": "git", "url": repository + ".git"}
package["homepage"] = repository
javascript.write_text(json.dumps(package, indent=2) + "\n")

python_setup = root / "clients/python/setup.py"
setup_text = python_setup.read_text()
setup_text = setup_text.replace('VERSION = "0.1.0"', f'VERSION = "{version}"')
setup_text = setup_text.replace('url="",', f'url="{repository}",')
python_setup.write_text(setup_text)

python_pyproject = root / "clients/python/pyproject.toml"
pyproject_text = python_pyproject.read_text()
pyproject_text = pyproject_text.replace('version = "0.1.0"', f'version = "{version}"', 1)
pyproject_text = pyproject_text.replace('license = "NoLicense"', 'license = "Apache-2.0"')
pyproject_text = pyproject_text.replace('repository = "https://github.com/GIT_USER_ID/GIT_REPO_ID"', f'repository = "{repository}"')
python_pyproject.write_text(pyproject_text)

maven_pom = root / "clients/java/pom.xml"
pom_text = maven_pom.read_text()
pom_text = pom_text.replace('<url>https://github.com/openapitools/openapi-generator</url>', f'<url>{repository}</url>', 1)
pom_text = pom_text.replace('<url>https://github.com/openapitools/openapi-generator</url>', f'<url>{repository}</url>')
pom_text = pom_text.replace('<description>OpenAPI Java</description>', '<description>Entloom OpenAPI Java client</description>')
pom_text = pom_text.replace('<connection>scm:git:git@github.com:openapitools/openapi-generator.git</connection>', '<connection>scm:git:git@github.com:dugufeng666/entloom.git</connection>')
pom_text = pom_text.replace('<developerConnection>scm:git:git@github.com:openapitools/openapi-generator.git</developerConnection>', '<developerConnection>scm:git:git@github.com:dugufeng666/entloom.git</developerConnection>')
pom_text = pom_text.replace('<name>Unlicense</name>', '<name>Apache License 2.0</name>')
pom_text = pom_text.replace('<url>http://unlicense.org</url>', '<url>https://www.apache.org/licenses/LICENSE-2.0</url>')
pom_text = pom_text.replace('<name>OpenAPI-Generator Contributors</name>', '<name>Entloom Contributors</name>')
pom_text = pom_text.replace('<email>team@openapitools.org</email>', '<email>opensource@entloom.io</email>')
pom_text = pom_text.replace('<organization>OpenAPITools.org</organization>', '<organization>Entloom</organization>')
pom_text = pom_text.replace('<organizationUrl>http://openapitools.org</organizationUrl>', f'<organizationUrl>{repository}</organizationUrl>')
pom_text = pom_text.replace('<version>1.5</version>', '<version>3.2.7</version>', 1)
central_plugin = """
                    <plugin>
                        <groupId>org.sonatype.central</groupId>
                        <artifactId>central-publishing-maven-plugin</artifactId>
                        <version>0.12.0</version>
                        <extensions>true</extensions>
                        <configuration>
                            <publishingServerId>central</publishingServerId>
                            <autoPublish>true</autoPublish>
                            <waitUntil>published</waitUntil>
                        </configuration>
                    </plugin>
"""
profile_close = """                </plugins>
            </build>
        </profile>
    </profiles>"""
pom_text = pom_text.replace(profile_close, central_plugin + profile_close, 1)
maven_pom.write_text(pom_text)
PY
