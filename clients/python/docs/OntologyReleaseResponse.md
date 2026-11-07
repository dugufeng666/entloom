# OntologyReleaseResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **str** |  | [optional]
**ontology_id** | **str** |  | [optional]
**version** | **str** |  | [optional]
**notes** | **str** |  | [optional]
**released_by** | **str** |  | [optional]
**released_at** | **datetime** |  | [optional]
**class_count** | **int** |  | [optional]
**property_count** | **int** |  | [optional]
**relation_count** | **int** |  | [optional]

## Example

```python
from entloom_client.models.ontology_release_response import OntologyReleaseResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyReleaseResponse from a JSON string
ontology_release_response_instance = OntologyReleaseResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyReleaseResponse.to_json())

# convert the object into a dict
ontology_release_response_dict = ontology_release_response_instance.to_dict()
# create an instance of OntologyReleaseResponse from a dict
ontology_release_response_from_dict = OntologyReleaseResponse.from_dict(ontology_release_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


