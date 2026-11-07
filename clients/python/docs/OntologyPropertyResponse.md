# OntologyPropertyResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional]
**ontology_id** | **str** |  | [optional]
**class_id** | **str** |  | [optional]
**name** | **str** |  | [optional]
**description** | **str** |  | [optional]
**value_type** | **str** |  | [optional]
**required** | **bool** |  | [optional]
**created_at** | **datetime** |  | [optional]
**updated_at** | **datetime** |  | [optional]
**version** | **int** |  | [optional]

## Example

```python
from entloom_client.models.ontology_property_response import OntologyPropertyResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyPropertyResponse from a JSON string
ontology_property_response_instance = OntologyPropertyResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyPropertyResponse.to_json())

# convert the object into a dict
ontology_property_response_dict = ontology_property_response_instance.to_dict()
# create an instance of OntologyPropertyResponse from a dict
ontology_property_response_from_dict = OntologyPropertyResponse.from_dict(ontology_property_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


