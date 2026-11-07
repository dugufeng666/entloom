# UpdateOntologyPropertyRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]
**value_type** | **str** |  |
**required** | **bool** |  |

## Example

```python
from entloom_client.models.update_ontology_property_request import UpdateOntologyPropertyRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateOntologyPropertyRequest from a JSON string
update_ontology_property_request_instance = UpdateOntologyPropertyRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateOntologyPropertyRequest.to_json())

# convert the object into a dict
update_ontology_property_request_dict = update_ontology_property_request_instance.to_dict()
# create an instance of UpdateOntologyPropertyRequest from a dict
update_ontology_property_request_from_dict = UpdateOntologyPropertyRequest.from_dict(update_ontology_property_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


