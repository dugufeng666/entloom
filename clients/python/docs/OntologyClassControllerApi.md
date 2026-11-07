# entloom_client.OntologyClassControllerApi

All URIs are relative to *http://localhost:18080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create3**](OntologyClassControllerApi.md#create3) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes |
[**delete1**](OntologyClassControllerApi.md#delete1) | **DELETE** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id} |
[**get1**](OntologyClassControllerApi.md#get1) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id} |
[**list4**](OntologyClassControllerApi.md#list4) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes |
[**update1**](OntologyClassControllerApi.md#update1) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/classes/{id} |


# **create3**
> OntologyClassResponse create3(project_id, ontology_id, create_ontology_class_request)



### Example


```python
import entloom_client
from entloom_client.models.create_ontology_class_request import CreateOntologyClassRequest
from entloom_client.models.ontology_class_response import OntologyClassResponse
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
    api_instance = entloom_client.OntologyClassControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    create_ontology_class_request = entloom_client.CreateOntologyClassRequest() # CreateOntologyClassRequest |

    try:
        api_response = api_instance.create3(project_id, ontology_id, create_ontology_class_request)
        print("The response of OntologyClassControllerApi->create3:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyClassControllerApi->create3: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **create_ontology_class_request** | [**CreateOntologyClassRequest**](CreateOntologyClassRequest.md)|  |

### Return type

[**OntologyClassResponse**](OntologyClassResponse.md)

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

# **delete1**
> delete1(project_id, ontology_id, id)



### Example


```python
import entloom_client
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
    api_instance = entloom_client.OntologyClassControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    id = 'id_example' # str |

    try:
        api_instance.delete1(project_id, ontology_id, id)
    except Exception as e:
        print("Exception when calling OntologyClassControllerApi->delete1: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **id** | **str**|  |

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | No Content |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get1**
> OntologyClassResponse get1(project_id, ontology_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_class_response import OntologyClassResponse
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
    api_instance = entloom_client.OntologyClassControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.get1(project_id, ontology_id, id)
        print("The response of OntologyClassControllerApi->get1:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyClassControllerApi->get1: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**OntologyClassResponse**](OntologyClassResponse.md)

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

# **list4**
> List[OntologyClassResponse] list4(project_id, ontology_id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_class_response import OntologyClassResponse
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
    api_instance = entloom_client.OntologyClassControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |

    try:
        api_response = api_instance.list4(project_id, ontology_id)
        print("The response of OntologyClassControllerApi->list4:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyClassControllerApi->list4: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |

### Return type

[**List[OntologyClassResponse]**](OntologyClassResponse.md)

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

# **update1**
> OntologyClassResponse update1(project_id, ontology_id, id, update_ontology_class_request)



### Example


```python
import entloom_client
from entloom_client.models.ontology_class_response import OntologyClassResponse
from entloom_client.models.update_ontology_class_request import UpdateOntologyClassRequest
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
    api_instance = entloom_client.OntologyClassControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    id = 'id_example' # str |
    update_ontology_class_request = entloom_client.UpdateOntologyClassRequest() # UpdateOntologyClassRequest |

    try:
        api_response = api_instance.update1(project_id, ontology_id, id, update_ontology_class_request)
        print("The response of OntologyClassControllerApi->update1:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyClassControllerApi->update1: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **id** | **str**|  |
 **update_ontology_class_request** | [**UpdateOntologyClassRequest**](UpdateOntologyClassRequest.md)|  |

### Return type

[**OntologyClassResponse**](OntologyClassResponse.md)

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

