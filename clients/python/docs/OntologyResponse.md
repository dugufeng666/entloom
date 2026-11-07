# OntologyResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional]
**project_id** | **str** |  | [optional]
**name** | **str** |  | [optional]
**description** | **str** |  | [optional]
**status** | **str** |  | [optional]
**require_class_properties** | **bool** |  | [optional]
**allow_self_relations** | **bool** |  | [optional]
**created_at** | **datetime** |  | [optional]
**updated_at** | **datetime** |  | [optional]
**version** | **int** |  | [optional]

## Example

```python
from entloom_client.models.ontology_response import OntologyResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyResponse from a JSON string
ontology_response_instance = OntologyResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyResponse.to_json())

# convert the object into a dict
ontology_response_dict = ontology_response_instance.to_dict()
# create an instance of OntologyResponse from a dict
ontology_response_from_dict = OntologyResponse.from_dict(ontology_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


