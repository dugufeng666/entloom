# RelationTransfer


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]
**source_class** | **str** |  | [optional]
**target_class** | **str** |  | [optional]
**cardinality** | **str** |  | [optional]

## Example

```python
from entloom_client.models.relation_transfer import RelationTransfer

# TODO update the JSON string below
json = "{}"
# create an instance of RelationTransfer from a JSON string
relation_transfer_instance = RelationTransfer.from_json(json)
# print the JSON string representation of the object
print(RelationTransfer.to_json())

# convert the object into a dict
relation_transfer_dict = relation_transfer_instance.to_dict()
# create an instance of RelationTransfer from a dict
relation_transfer_from_dict = RelationTransfer.from_dict(relation_transfer_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


