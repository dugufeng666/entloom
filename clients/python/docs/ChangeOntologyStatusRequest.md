# ChangeOntologyStatusRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **str** |  |

## Example

```python
from entloom_client.models.change_ontology_status_request import ChangeOntologyStatusRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ChangeOntologyStatusRequest from a JSON string
change_ontology_status_request_instance = ChangeOntologyStatusRequest.from_json(json)
# print the JSON string representation of the object
print(ChangeOntologyStatusRequest.to_json())

# convert the object into a dict
change_ontology_status_request_dict = change_ontology_status_request_instance.to_dict()
# create an instance of ChangeOntologyStatusRequest from a dict
change_ontology_status_request_from_dict = ChangeOntologyStatusRequest.from_dict(change_ontology_status_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


