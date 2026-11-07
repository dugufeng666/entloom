# UpdateOntologyLayoutRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**positions** | [**Dict[str, OntologyLayoutPosition]**](OntologyLayoutPosition.md) |  | [optional]

## Example

```python
from entloom_client.models.update_ontology_layout_request import UpdateOntologyLayoutRequest

# TODO update the JSON string below
json = "{}"
# create an instance of UpdateOntologyLayoutRequest from a JSON string
update_ontology_layout_request_instance = UpdateOntologyLayoutRequest.from_json(json)
# print the JSON string representation of the object
print(UpdateOntologyLayoutRequest.to_json())

# convert the object into a dict
update_ontology_layout_request_dict = update_ontology_layout_request_instance.to_dict()
# create an instance of UpdateOntologyLayoutRequest from a dict
update_ontology_layout_request_from_dict = UpdateOntologyLayoutRequest.from_dict(update_ontology_layout_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


