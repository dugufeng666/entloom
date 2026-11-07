# ForkOntologyRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]

## Example

```python
from entloom_client.models.fork_ontology_request import ForkOntologyRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ForkOntologyRequest from a JSON string
fork_ontology_request_instance = ForkOntologyRequest.from_json(json)
# print the JSON string representation of the object
print(ForkOntologyRequest.to_json())

# convert the object into a dict
fork_ontology_request_dict = fork_ontology_request_instance.to_dict()
# create an instance of ForkOntologyRequest from a dict
fork_ontology_request_from_dict = ForkOntologyRequest.from_dict(fork_ontology_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


