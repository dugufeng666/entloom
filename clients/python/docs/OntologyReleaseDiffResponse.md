# OntologyReleaseDiffResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**from_release_id** | **str** |  | [optional]
**from_version** | **str** |  | [optional]
**to_release_id** | **str** |  | [optional]
**to_version** | **str** |  | [optional]
**changes** | [**List[OntologyReleaseChange]**](OntologyReleaseChange.md) |  | [optional]

## Example

```python
from entloom_client.models.ontology_release_diff_response import OntologyReleaseDiffResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyReleaseDiffResponse from a JSON string
ontology_release_diff_response_instance = OntologyReleaseDiffResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyReleaseDiffResponse.to_json())

# convert the object into a dict
ontology_release_diff_response_dict = ontology_release_diff_response_instance.to_dict()
# create an instance of OntologyReleaseDiffResponse from a dict
ontology_release_diff_response_from_dict = OntologyReleaseDiffResponse.from_dict(ontology_release_diff_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


