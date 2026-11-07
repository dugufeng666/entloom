# OntologyTransferRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]
**classes** | [**List[ClassTransfer]**](ClassTransfer.md) |  | [optional]
**relations** | [**List[RelationTransfer]**](RelationTransfer.md) |  | [optional]

## Example

```python
from entloom_client.models.ontology_transfer_request import OntologyTransferRequest

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyTransferRequest from a JSON string
ontology_transfer_request_instance = OntologyTransferRequest.from_json(json)
# print the JSON string representation of the object
print(OntologyTransferRequest.to_json())

# convert the object into a dict
ontology_transfer_request_dict = ontology_transfer_request_instance.to_dict()
# create an instance of OntologyTransferRequest from a dict
ontology_transfer_request_from_dict = OntologyTransferRequest.from_dict(ontology_transfer_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


