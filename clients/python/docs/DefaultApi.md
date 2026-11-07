# entloom_client.DefaultApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**api_v1_auth_me_get**](DefaultApi.md#api_v1_auth_me_get) | **GET** /api/v1/auth/me | Read the authenticated user
[**api_v1_projects_get**](DefaultApi.md#api_v1_projects_get) | **GET** /api/v1/projects | List projects
[**api_v1_projects_post**](DefaultApi.md#api_v1_projects_post) | **POST** /api/v1/projects | Create a project
[**api_v1_projects_project_id_ontologies_get**](DefaultApi.md#api_v1_projects_project_id_ontologies_get) | **GET** /api/v1/projects/{projectId}/ontologies | List project ontologies
[**api_v1_projects_project_id_ontologies_import_post**](DefaultApi.md#api_v1_projects_project_id_ontologies_import_post) | **POST** /api/v1/projects/{projectId}/ontologies/import | Import a transfer JSON document as a new draft
[**api_v1_projects_project_id_ontologies_ontology_id_export_get**](DefaultApi.md#api_v1_projects_project_id_ontologies_ontology_id_export_get) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/export | Export an ontology as transfer JSON
[**api_v1_projects_project_id_ontologies_ontology_id_layout_get**](DefaultApi.md#api_v1_projects_project_id_ontologies_ontology_id_layout_get) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/layout | Read graph layout
[**api_v1_projects_project_id_ontologies_ontology_id_layout_patch**](DefaultApi.md#api_v1_projects_project_id_ontologies_ontology_id_layout_patch) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/layout | Save graph layout
[**api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_get**](DefaultApi.md#api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_get) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/validation-jobs | List validation jobs
[**api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_post**](DefaultApi.md#api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_post) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/validation-jobs | Run a validation job
[**api_v1_projects_project_id_ontologies_post**](DefaultApi.md#api_v1_projects_project_id_ontologies_post) | **POST** /api/v1/projects/{projectId}/ontologies | Create an ontology


# **api_v1_auth_me_get**
> api_v1_auth_me_get()

Read the authenticated user

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)

    try:
        # Read the authenticated user
        api_instance.api_v1_auth_me_get()
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_auth_me_get: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Authenticated user |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_get**
> api_v1_projects_get()

List projects

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)

    try:
        # List projects
        api_instance.api_v1_projects_get()
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_get: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Project list |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_post**
> api_v1_projects_post()

Create a project

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)

    try:
        # Create a project
        api_instance.api_v1_projects_post()
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_post: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created project |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_get**
> api_v1_projects_project_id_ontologies_get(project_id)

List project ontologies

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 

    try:
        # List project ontologies
        api_instance.api_v1_projects_project_id_ontologies_get(project_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_get: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Ontology list |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_import_post**
> api_v1_projects_project_id_ontologies_import_post(project_id)

Import a transfer JSON document as a new draft

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 

    try:
        # Import a transfer JSON document as a new draft
        api_instance.api_v1_projects_project_id_ontologies_import_post(project_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_import_post: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Imported draft ontology |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_ontology_id_export_get**
> api_v1_projects_project_id_ontologies_ontology_id_export_get(project_id, ontology_id)

Export an ontology as transfer JSON

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 
    ontology_id = 'ontology_id_example' # str | 

    try:
        # Export an ontology as transfer JSON
        api_instance.api_v1_projects_project_id_ontologies_ontology_id_export_get(project_id, ontology_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_ontology_id_export_get: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 
 **ontology_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Ontology transfer document |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_ontology_id_layout_get**
> api_v1_projects_project_id_ontologies_ontology_id_layout_get(project_id, ontology_id)

Read graph layout

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 
    ontology_id = 'ontology_id_example' # str | 

    try:
        # Read graph layout
        api_instance.api_v1_projects_project_id_ontologies_ontology_id_layout_get(project_id, ontology_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_ontology_id_layout_get: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 
 **ontology_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Graph layout |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_ontology_id_layout_patch**
> api_v1_projects_project_id_ontologies_ontology_id_layout_patch(project_id, ontology_id)

Save graph layout

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 
    ontology_id = 'ontology_id_example' # str | 

    try:
        # Save graph layout
        api_instance.api_v1_projects_project_id_ontologies_ontology_id_layout_patch(project_id, ontology_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_ontology_id_layout_patch: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 
 **ontology_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Saved graph layout |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_get**
> api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_get(project_id, ontology_id)

List validation jobs

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 
    ontology_id = 'ontology_id_example' # str | 

    try:
        # List validation jobs
        api_instance.api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_get(project_id, ontology_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_get: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 
 **ontology_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Validation job history |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_post**
> api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_post(project_id, ontology_id)

Run a validation job

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 
    ontology_id = 'ontology_id_example' # str | 

    try:
        # Run a validation job
        api_instance.api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_post(project_id, ontology_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_ontology_id_validation_jobs_post: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 
 **ontology_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Completed validation job |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **api_v1_projects_project_id_ontologies_post**
> api_v1_projects_project_id_ontologies_post(project_id)

Create an ontology

### Example

* Basic Authentication (basicAuth):

```python
import entloom_client
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:8080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:8080"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure HTTP basic authorization: basicAuth
configuration = entloom_client.Configuration(
    username = os.environ["USERNAME"],
    password = os.environ["PASSWORD"]
)

# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.DefaultApi(api_client)
    project_id = 'project_id_example' # str | 

    try:
        # Create an ontology
        api_instance.api_v1_projects_project_id_ontologies_post(project_id)
    except Exception as e:
        print("Exception when calling DefaultApi->api_v1_projects_project_id_ontologies_post: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  | 

### Return type

void (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created ontology |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

