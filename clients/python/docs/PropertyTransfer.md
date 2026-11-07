# PropertyTransfer


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]
**value_type** | **str** |  | [optional]
**required** | **bool** |  | [optional]

## Example

```python
from entloom_client.models.property_transfer import PropertyTransfer

# TODO update the JSON string below
json = "{}"
# create an instance of PropertyTransfer from a JSON string
property_transfer_instance = PropertyTransfer.from_json(json)
# print the JSON string representation of the object
print(PropertyTransfer.to_json())

# convert the object into a dict
property_transfer_dict = property_transfer_instance.to_dict()
# create an instance of PropertyTransfer from a dict
property_transfer_from_dict = PropertyTransfer.from_dict(property_transfer_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


