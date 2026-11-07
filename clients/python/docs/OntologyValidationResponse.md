# OntologyValidationResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**valid** | **bool** |  | [optional]
**issues** | [**List[Issue]**](Issue.md) |  | [optional]

## Example

```python
from entloom_client.models.ontology_validation_response import OntologyValidationResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyValidationResponse from a JSON string
ontology_validation_response_instance = OntologyValidationResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyValidationResponse.to_json())

# convert the object into a dict
ontology_validation_response_dict = ontology_validation_response_instance.to_dict()
# create an instance of OntologyValidationResponse from a dict
ontology_validation_response_from_dict = OntologyValidationResponse.from_dict(ontology_validation_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


