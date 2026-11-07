# CreateOntologyRelationRequest


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
from entloom_client.models.create_ontology_relation_request import CreateOntologyRelationRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateOntologyRelationRequest from a JSON string
create_ontology_relation_request_instance = CreateOntologyRelationRequest.from_json(json)
# print the JSON string representation of the object
print(CreateOntologyRelationRequest.to_json())

# convert the object into a dict
create_ontology_relation_request_dict = create_ontology_relation_request_instance.to_dict()
# create an instance of CreateOntologyRelationRequest from a dict
create_ontology_relation_request_from_dict = CreateOntologyRelationRequest.from_dict(create_ontology_relation_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


