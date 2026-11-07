# CurrentUserResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**username** | **str** |  | [optional]
**roles** | **List[str]** |  | [optional]

## Example

```python
from entloom_client.models.current_user_response import CurrentUserResponse

# TODO update the JSON string below
json = "{}"
# create an instance of CurrentUserResponse from a JSON string
current_user_response_instance = CurrentUserResponse.from_json(json)
# print the JSON string representation of the object
print(CurrentUserResponse.to_json())

# convert the object into a dict
current_user_response_dict = current_user_response_instance.to_dict()
# create an instance of CurrentUserResponse from a dict
current_user_response_from_dict = CurrentUserResponse.from_dict(current_user_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


