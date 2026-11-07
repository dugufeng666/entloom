# OntologyLayoutResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**positions** | [**Dict[str, OntologyLayoutPosition]**](OntologyLayoutPosition.md) |  | [optional]

## Example

```python
from entloom_client.models.ontology_layout_response import OntologyLayoutResponse

# TODO update the JSON string below
json = "{}"
# create an instance of OntologyLayoutResponse from a JSON string
ontology_layout_response_instance = OntologyLayoutResponse.from_json(json)
# print the JSON string representation of the object
print(OntologyLayoutResponse.to_json())

# convert the object into a dict
ontology_layout_response_dict = ontology_layout_response_instance.to_dict()
# create an instance of OntologyLayoutResponse from a dict
ontology_layout_response_from_dict = OntologyLayoutResponse.from_dict(ontology_layout_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


