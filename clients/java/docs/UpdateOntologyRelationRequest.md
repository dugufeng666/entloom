

# UpdateOntologyRelationRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** |  |  |
|**description** | **String** |  |  [optional] |
|**sourceClassId** | **UUID** |  |  |
|**targetClassId** | **UUID** |  |  |
|**cardinality** | [**CardinalityEnum**](#CardinalityEnum) |  |  |



## Enum: CardinalityEnum

| Name | Value |
|---- | -----|
| ONE_TO_ONE | &quot;ONE_TO_ONE&quot; |
| ONE_TO_MANY | &quot;ONE_TO_MANY&quot; |
| MANY_TO_ONE | &quot;MANY_TO_ONE&quot; |
| MANY_TO_MANY | &quot;MANY_TO_MANY&quot; |



