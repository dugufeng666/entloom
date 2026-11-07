# OntologyClassResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional]
**ontology_id** | **str** |  | [optional]
**name** | **str** |  | [optional]
**description** | **str** |  | [optional]
**created_at** | **datetime** |  | [optional]
**updated_at** | **datetime** |  | [optional]
**version** | **int** |  | [optional]

## Example

```python
from entloom_client.models.ontology_class_response import OntologyClassResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyClassResponse from a JSON string
ontology_class_response_instance = OntologyClassResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyClassResponse.to_json())

# convert the object into a dict
ontology_class_response_dict = ontology_class_response_instance.to_dict()
# create an instance of OntologyClassResponse from a dict
ontology_class_response_from_dict = OntologyClassResponse.from_dict(ontology_class_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


