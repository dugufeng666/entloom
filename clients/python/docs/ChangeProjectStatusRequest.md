# ChangeProjectStatusRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **str** |  |

## Example

```python
from entloom_client.models.change_project_status_request import ChangeProjectStatusRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ChangeProjectStatusRequest from a JSON string
change_project_status_request_instance = ChangeProjectStatusRequest.from_json(json)
# print the JSON string representation of the object
print(ChangeProjectStatusRequest.to_json())

# convert the object into a dict
change_project_status_request_dict = change_project_status_request_instance.to_dict()
# create an instance of ChangeProjectStatusRequest from a dict
change_project_status_request_from_dict = ChangeProjectStatusRequest.from_dict(change_project_status_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


