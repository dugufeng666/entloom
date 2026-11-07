# OntologyReleaseChange


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**kind** | **str** |  | [optional]
**change_type** | **str** |  | [optional]
**item_id** | **str** |  | [optional]
**name** | **str** |  | [optional]
**location** | **str** |  | [optional]
**before** | **object** |  | [optional]
**after** | **object** |  | [optional]

## Example

```python
from entloom_client.models.ontology_release_change import OntologyReleaseChange

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyReleaseChange from a JSON string
ontology_release_change_instance = OntologyReleaseChange.from_json(json)
# print the JSON string representation of the object
print(OntologyReleaseChange.to_json())

# convert the object into a dict
ontology_release_change_dict = ontology_release_change_instance.to_dict()
# create an instance of OntologyReleaseChange from a dict
ontology_release_change_from_dict = OntologyReleaseChange.from_dict(ontology_release_change_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


