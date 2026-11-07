# ClassTransfer


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **str** |  |
**description** | **str** |  | [optional]
**properties** | [**List[PropertyTransfer]**](PropertyTransfer.md) |  | [optional]

## Example

```python
from entloom_client.models.class_transfer import ClassTransfer

# TODO update the JSON string below
json = "{}"
# create an instance of ClassTransfer from a JSON string
class_transfer_instance = ClassTransfer.from_json(json)
# print the JSON string representation of the object
print(ClassTransfer.to_json())

# convert the object into a dict
class_transfer_dict = class_transfer_instance.to_dict()
# create an instance of ClassTransfer from a dict
class_transfer_from_dict = ClassTransfer.from_dict(class_transfer_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


