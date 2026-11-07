# entloom_client.OntologyRelationControllerApi

All URIs are relative to *http://localhost:18080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create2**](OntologyRelationControllerApi.md#create2) | **POST** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations |
[**delete**](OntologyRelationControllerApi.md#delete) | **DELETE** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id} |
[**get**](OntologyRelationControllerApi.md#get) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id} |
[**list3**](OntologyRelationControllerApi.md#list3) | **GET** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations |
[**update**](OntologyRelationControllerApi.md#update) | **PATCH** /api/v1/projects/{projectId}/ontologies/{ontologyId}/relations/{id} |


# **create2**
> OntologyRelationResponse create2(project_id, ontology_id, create_ontology_relation_request)



### Example


```python
import entloom_client
from entloom_client.models.create_ontology_relation_request import CreateOntologyRelationRequest
from entloom_client.models.ontology_relation_response import OntologyRelationResponse
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
    api_instance = entloom_client.OntologyRelationControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    create_ontology_relation_request = entloom_client.CreateOntologyRelationRequest() # CreateOntologyRelationRequest |

    try:
        api_response = api_instance.create2(project_id, ontology_id, create_ontology_relation_request)
        print("The response of OntologyRelationControllerApi->create2:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyRelationControllerApi->create2: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **create_ontology_relation_request** | [**CreateOntologyRelationRequest**](CreateOntologyRelationRequest.md)|  |

### Return type

[**OntologyRelationResponse**](OntologyRelationResponse.md)

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

# **delete**
> delete(project_id, ontology_id, id)



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
    api_instance = entloom_client.OntologyRelationControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    id = 'id_example' # str |

    try:
        api_instance.delete(project_id, ontology_id, id)
    except Exception as e:
        print("Exception when calling OntologyRelationControllerApi->delete: %s\n" % e)
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

# **get**
> OntologyRelationResponse get(project_id, ontology_id, id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_relation_response import OntologyRelationResponse
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
    api_instance = entloom_client.OntologyRelationControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    id = 'id_example' # str |

    try:
        api_response = api_instance.get(project_id, ontology_id, id)
        print("The response of OntologyRelationControllerApi->get:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyRelationControllerApi->get: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **id** | **str**|  |

### Return type

[**OntologyRelationResponse**](OntologyRelationResponse.md)

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

# **list3**
> List[OntologyRelationResponse] list3(project_id, ontology_id)



### Example


```python
import entloom_client
from entloom_client.models.ontology_relation_response import OntologyRelationResponse
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
    api_instance = entloom_client.OntologyRelationControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |

    try:
        api_response = api_instance.list3(project_id, ontology_id)
        print("The response of OntologyRelationControllerApi->list3:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyRelationControllerApi->list3: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |

### Return type

[**List[OntologyRelationResponse]**](OntologyRelationResponse.md)

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

# **update**
> OntologyRelationResponse update(project_id, ontology_id, id, update_ontology_relation_request)



### Example


```python
import entloom_client
from entloom_client.models.ontology_relation_response import OntologyRelationResponse
from entloom_client.models.update_ontology_relation_request import UpdateOntologyRelationRequest
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
    api_instance = entloom_client.OntologyRelationControllerApi(api_client)
    project_id = 'project_id_example' # str |
    ontology_id = 'ontology_id_example' # str |
    id = 'id_example' # str |
    update_ontology_relation_request = entloom_client.UpdateOntologyRelationRequest() # UpdateOntologyRelationRequest |

    try:
        api_response = api_instance.update(project_id, ontology_id, id, update_ontology_relation_request)
        print("The response of OntologyRelationControllerApi->update:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling OntologyRelationControllerApi->update: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project_id** | **str**|  |
 **ontology_id** | **str**|  |
 **id** | **str**|  |
 **update_ontology_relation_request** | [**UpdateOntologyRelationRequest**](UpdateOntologyRelationRequest.md)|  |

### Return type

[**OntologyRelationResponse**](OntologyRelationResponse.md)

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

