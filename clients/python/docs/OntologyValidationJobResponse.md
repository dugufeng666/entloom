# OntologyValidationJobResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional]
**ontology_id** | **str** |  | [optional]
**status** | **str** |  | [optional]
**issues** | [**List[Issue]**](Issue.md) |  | [optional]
**created_at** | **datetime** |  | [optional]
**finished_at** | **datetime** |  | [optional]

## Example

```python
from entloom_client.models.ontology_validation_job_response import OntologyValidationJobResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyValidationJobResponse from a JSON string
ontology_validation_job_response_instance = OntologyValidationJobResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyValidationJobResponse.to_json())

# convert the object into a dict
ontology_validation_job_response_dict = ontology_validation_job_response_instance.to_dict()
# create an instance of OntologyValidationJobResponse from a dict
ontology_validation_job_response_from_dict = OntologyValidationJobResponse.from_dict(ontology_validation_job_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


