# UpdateOntologyRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]
**require_class_properties** | **bool** |  | [optional]
**allow_self_relations** | **bool** |  | [optional]

## Example

```python
from entloom_client.models.update_ontology_request import UpdateOntologyRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateOntologyRequest from a JSON string
update_ontology_request_instance = UpdateOntologyRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateOntologyRequest.to_json())

# convert the object into a dict
update_ontology_request_dict = update_ontology_request_instance.to_dict()
# create an instance of UpdateOntologyRequest from a dict
update_ontology_request_from_dict = UpdateOntologyRequest.from_dict(update_ontology_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


