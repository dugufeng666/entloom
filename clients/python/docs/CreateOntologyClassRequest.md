# CreateOntologyClassRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]

## Example

```python
from entloom_client.models.create_ontology_class_request import CreateOntologyClassRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateOntologyClassRequest from a JSON string
create_ontology_class_request_instance = CreateOntologyClassRequest.from_json(json)
# print the JSON string representation of the object
print(CreateOntologyClassRequest.to_json())

# convert the object into a dict
create_ontology_class_request_dict = create_ontology_class_request_instance.to_dict()
# create an instance of CreateOntologyClassRequest from a dict
create_ontology_class_request_from_dict = CreateOntologyClassRequest.from_dict(create_ontology_class_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


