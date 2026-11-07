# entloom_client.AuthControllerApi

All URIs are relative to *http://localhost:18080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**current_user**](AuthControllerApi.md#current_user) | **GET** /api/v1/auth/me |


# **current_user**
> CurrentUserResponse current_user()



### Example


```python
import entloom_client
from entloom_client.models.current_user_response import CurrentUserResponse
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
    api_instance = entloom_client.AuthControllerApi(api_client)

    try:
        api_response = api_instance.current_user()
        print("The response of AuthControllerApi->current_user:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AuthControllerApi->current_user: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**CurrentUserResponse**](CurrentUserResponse.md)

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

