# entloom_client.OntologyReleaseControllerApi

All URIs are relative to *http://localhost:18080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**diff**](OntologyReleaseControllerApi.md#diff) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/releases/diff |
[**list2**](OntologyReleaseControllerApi.md#list2) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/releases |
[**release**](OntologyReleaseControllerApi.md#release) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/releases |


# **diff**
> OntologyReleaseDiffResponse diff(project_id, ontology_id, var_from, to)



### Example


```python
import entloom_client
from entloom_client.models.ontology_release_diff_response import OntologyReleaseDiffResponse
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
    api_instance = entloom_client.OntologyReleaseControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    var_from = 'var_from_example' # str |
    to = 'to_example' # str |

    try:
        api_response = api_instance.diff(project_id, ontology_id, var_from, to)
        print("The response of OntologyReleaseControllerApi->diff:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyReleaseControllerApi->diff: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **var_from** | **str**|  |
 **to** | **str**|  |

### Return type

[**OntologyReleaseDiffResponse**](OntologyReleaseDiffResponse.md)

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

# **list2**
> List[OntologyReleaseResponse] list2(project_id, ontology_id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_release_response import OntologyReleaseResponse
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
    api_instance = entloom_client.OntologyReleaseControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |

    try:
        api_response = api_instance.list2(project_id, ontology_id)
        print("The response of OntologyReleaseControllerApi->list2:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyReleaseControllerApi->list2: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |

### Return type

[**List[OntologyReleaseResponse]**](OntologyReleaseResponse.md)

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

# **release**
> OntologyReleaseResponse release(project_id, ontology_id, release_ontology_request)



### Example


```python
import entloom_client
from entloom_client.models.ontology_release_response import OntologyReleaseResponse
from entloom_client.models.release_ontology_request import ReleaseOntologyRequest
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
    api_instance = entloom_client.OntologyReleaseControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    release_ontology_request = entloom_client.ReleaseOntologyRequest() # ReleaseOntologyRequest |

    try:
        api_response = api_instance.release(project_id, ontology_id, release_ontology_request)
        print("The response of OntologyReleaseControllerApi->release:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyReleaseControllerApi->release: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **release_ontology_request** | [**ReleaseOntologyRequest**](ReleaseOntologyRequest.md)|  |

### Return type

[**OntologyReleaseResponse**](OntologyReleaseResponse.md)

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

