# UpdateOntologyClassRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]

## Example

```python
from entloom_client.models.update_ontology_class_request import UpdateOntologyClassRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateOntologyClassRequest from a JSON string
update_ontology_class_request_instance = UpdateOntologyClassRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateOntologyClassRequest.to_json())

# convert the object into a dict
update_ontology_class_request_dict = update_ontology_class_request_instance.to_dict()
# create an instance of UpdateOntologyClassRequest from a dict
update_ontology_class_request_from_dict = UpdateOntologyClassRequest.from_dict(update_ontology_class_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


