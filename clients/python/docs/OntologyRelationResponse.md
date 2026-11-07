# OntologyRelationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional]
**ontology_id** | **str** |  | [optional]
**source_class_id** | **str** |  | [optional]
**target_class_id** | **str** |  | [optional]
**name** | **str** |  | [optional]
**description** | **str** |  | [optional]
**cardinality** | **str** |  | [optional]
**created_at** | **datetime** |  | [optional]
**updated_at** | **datetime** |  | [optional]
**version** | **int** |  | [optional]

## Example

```python
from entloom_client.models.ontology_relation_response import OntologyRelationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyRelationResponse from a JSON string
ontology_relation_response_instance = OntologyRelationResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyRelationResponse.to_json())

# convert the object into a dict
ontology_relation_response_dict = ontology_relation_response_instance.to_dict()
# create an instance of OntologyRelationResponse from a dict
ontology_relation_response_from_dict = OntologyRelationResponse.from_dict(ontology_relation_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


