# entloom_client.OntologyControllerApi

All URIs are relative to *http://localhost:18080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**change_status**](OntologyControllerApi.md#change_status) | **PATCH** /api/v1/projects/{projectId}/ontologies/{id}/status |
[**create1**](OntologyControllerApi.md#create1) | **POST** /api/v1/projects/{projectId}/ontologies |
[**export**](OntologyControllerApi.md#export) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/export |
[**fork**](OntologyControllerApi.md#fork) | **POST** /api/v1/projects/{projectId}/ontologies/{id}/fork |
[**get3**](OntologyControllerApi.md#get3) | **GET** /api/v1/projects/{projectId}/ontologies/{id} |
[**import_ontology**](OntologyControllerApi.md#import_ontology) | **POST** /api/v1/projects/{projectId}/ontologies/import |
[**layout**](OntologyControllerApi.md#layout) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/layout |
[**list1**](OntologyControllerApi.md#list1) | **GET** /api/v1/projects/{projectId}/ontologies |
[**list_validation_jobs**](OntologyControllerApi.md#list_validation_jobs) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/validation-jobs |
[**run_validation_job**](OntologyControllerApi.md#run_validation_job) | **POST** /api/v1/projects/{projectId}/ontologies/{id}/validation-jobs |
[**update3**](OntologyControllerApi.md#update3) | **PATCH** /api/v1/projects/{projectId}/ontologies/{id} |
[**update_layout**](OntologyControllerApi.md#update_layout) | **PATCH** /api/v1/projects/{projectId}/ontologies/{id}/layout |
[**validate**](OntologyControllerApi.md#validate) | **GET** /api/v1/projects/{projectId}/ontologies/{id}/validation |


# **change_status**
> OntologyResponse change_status(project_id, id, change_ontology_status_request)



### Example


```python
import entloom_client
from entloom_client.models.change_ontology_status_request import ChangeOntologyStatusRequest
from entloom_client.models.ontology_response import OntologyResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |
    change_ontology_status_request = entloom_client.ChangeOntologyStatusRequest() # ChangeOntologyStatusRequest |

    try:
        api_response = api_instance.change_status(project_id, id, change_ontology_status_request)
        print("The response of OntologyControllerApi->change_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->change_status: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |
 **change_ontology_status_request** | [**ChangeOntologyStatusRequest**](ChangeOntologyStatusRequest.md)|  |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **create1**
> OntologyResponse create1(project_id, create_ontology_request)



### Example


```python
import entloom_client
from entloom_client.models.create_ontology_request import CreateOntologyRequest
from entloom_client.models.ontology_response import OntologyResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    create_ontology_request = entloom_client.CreateOntologyRequest() # CreateOntologyRequest |

    try:
        api_response = api_instance.create1(project_id, create_ontology_request)
        print("The response of OntologyControllerApi->create1:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->create1: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **create_ontology_request** | [**CreateOntologyRequest**](CreateOntologyRequest.md)|  |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **export**
> OntologyTransferRequest export(project_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_transfer_request import OntologyTransferRequest
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.export(project_id, id)
        print("The response of OntologyControllerApi->export:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->export: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**OntologyTransferRequest**](OntologyTransferRequest.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **fork**
> OntologyResponse fork(project_id, id, fork_ontology_request)



### Example


```python
import entloom_client
from entloom_client.models.fork_ontology_request import ForkOntologyRequest
from entloom_client.models.ontology_response import OntologyResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |
    fork_ontology_request = entloom_client.ForkOntologyRequest() # ForkOntologyRequest |

    try:
        api_response = api_instance.fork(project_id, id, fork_ontology_request)
        print("The response of OntologyControllerApi->fork:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->fork: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |
 **fork_ontology_request** | [**ForkOntologyRequest**](ForkOntologyRequest.md)|  |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get3**
> OntologyResponse get3(project_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_response import OntologyResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.get3(project_id, id)
        print("The response of OntologyControllerApi->get3:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->get3: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **import_ontology**
> OntologyResponse import_ontology(project_id, ontology_transfer_request)



### Example


```python
import entloom_client
from entloom_client.models.ontology_response import OntologyResponse
from entloom_client.models.ontology_transfer_request import OntologyTransferRequest
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_transfer_request = entloom_client.OntologyTransferRequest() # OntologyTransferRequest |

    try:
        api_response = api_instance.import_ontology(project_id, ontology_transfer_request)
        print("The response of OntologyControllerApi->import_ontology:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->import_ontology: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_transfer_request** | [**OntologyTransferRequest**](OntologyTransferRequest.md)|  |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **layout**
> OntologyLayoutResponse layout(project_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_layout_response import OntologyLayoutResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.layout(project_id, id)
        print("The response of OntologyControllerApi->layout:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->layout: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**OntologyLayoutResponse**](OntologyLayoutResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list1**
> List[OntologyResponse] list1(project_id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_response import OntologyResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |

    try:
        api_response = api_instance.list1(project_id)
        print("The response of OntologyControllerApi->list1:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->list1: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |

### Return type

[**List[OntologyResponse]**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_validation_jobs**
> List[OntologyValidationJobResponse] list_validation_jobs(project_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_validation_job_response import OntologyValidationJobResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.list_validation_jobs(project_id, id)
        print("The response of OntologyControllerApi->list_validation_jobs:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->list_validation_jobs: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**List[OntologyValidationJobResponse]**](OntologyValidationJobResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **run_validation_job**
> OntologyValidationJobResponse run_validation_job(project_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_validation_job_response import OntologyValidationJobResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.run_validation_job(project_id, id)
        print("The response of OntologyControllerApi->run_validation_job:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->run_validation_job: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**OntologyValidationJobResponse**](OntologyValidationJobResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Created |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update3**
> OntologyResponse update3(project_id, id, update_ontology_request)



### Example


```python
import entloom_client
from entloom_client.models.ontology_response import OntologyResponse
from entloom_client.models.update_ontology_request import UpdateOntologyRequest
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |
    update_ontology_request = entloom_client.UpdateOntologyRequest() # UpdateOntologyRequest |

    try:
        api_response = api_instance.update3(project_id, id, update_ontology_request)
        print("The response of OntologyControllerApi->update3:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->update3: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |
 **update_ontology_request** | [**UpdateOntologyRequest**](UpdateOntologyRequest.md)|  |

### Return type

[**OntologyResponse**](OntologyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_layout**
> OntologyLayoutResponse update_layout(project_id, id, update_ontology_layout_request)



### Example


```python
import entloom_client
from entloom_client.models.ontology_layout_response import OntologyLayoutResponse
from entloom_client.models.update_ontology_layout_request import UpdateOntologyLayoutRequest
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |
    update_ontology_layout_request = entloom_client.UpdateOntologyLayoutRequest() # UpdateOntologyLayoutRequest |

    try:
        api_response = api_instance.update_layout(project_id, id, update_ontology_layout_request)
        print("The response of OntologyControllerApi->update_layout:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->update_layout: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |
 **update_ontology_layout_request** | [**UpdateOntologyLayoutRequest**](UpdateOntologyLayoutRequest.md)|  |

### Return type

[**OntologyLayoutResponse**](OntologyLayoutResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate**
> OntologyValidationResponse validate(project_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_validation_response import OntologyValidationResponse
from entloom_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost:18080
# See configuration.py for a list of all supported configuration parameters.
configuration = entloom_client.Configuration(
    host = "http://localhost:18080"
)


# Enter a context with an instance of the API client
with entloom_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = entloom_client.OntologyControllerApi(api_client)
    project_id = 'project_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.validate(project_id, id)
        print("The response of OntologyControllerApi->validate:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyControllerApi->validate: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**OntologyValidationResponse**](OntologyValidationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

