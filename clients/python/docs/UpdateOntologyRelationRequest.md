# UpdateOntologyRelationRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]
**source_class_id** | **str** |  |
**target_class_id** | **str** |  |
**cardinality** | **str** |  |

## Example

```python
from entloom_client.models.update_ontology_relation_request import UpdateOntologyRelationRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateOntologyRelationRequest from a JSON string
update_ontology_relation_request_instance = UpdateOntologyRelationRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateOntologyRelationRequest.to_json())

# convert the object into a dict
update_ontology_relation_request_dict = update_ontology_relation_request_instance.to_dict()
# create an instance of UpdateOntologyRelationRequest from a dict
update_ontology_relation_request_from_dict = UpdateOntologyRelationRequest.from_dict(update_ontology_relation_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


