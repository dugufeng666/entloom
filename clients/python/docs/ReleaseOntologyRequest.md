# ReleaseOntologyRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**version** | **str** |  |
**notes** | **str** |  | [optional]

## Example

```python
from entloom_client.models.release_ontology_request import ReleaseOntologyRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ReleaseOntologyRequest from a JSON string
release_ontology_request_instance = ReleaseOntologyRequest.from_json(json)
# print the JSON string representation of the object
print(ReleaseOntologyRequest.to_json())

# convert the object into a dict
release_ontology_request_dict = release_ontology_request_instance.to_dict()
# create an instance of ReleaseOntologyRequest from a dict
release_ontology_request_from_dict = ReleaseOntologyRequest.from_dict(release_ontology_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


