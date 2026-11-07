# CreateOntologyRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]

## Example

```python
from entloom_client.models.create_ontology_request import CreateOntologyRequest

# TODO update the JSON string below
json = "{}"
# create an instance of CreateOntologyRequest from a JSON string
create_ontology_request_instance = CreateOntologyRequest.from_json(json)
# print the JSON string representation of the object
print(CreateOntologyRequest.to_json())

# convert the object into a dict
create_ontology_request_dict = create_ontology_request_instance.to_dict()
# create an instance of CreateOntologyRequest from a dict
create_ontology_request_from_dict = CreateOntologyRequest.from_dict(create_ontology_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


