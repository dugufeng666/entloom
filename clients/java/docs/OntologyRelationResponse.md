

# OntologyRelationResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  [optional] |
|**ontologyId** | **UUID** |  |  [optional] |
|**sourceClassId** | **UUID** |  |  [optional] |
|**targetClassId** | **UUID** |  |  [optional] |
|**name** | **String** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**cardinality** | [**CardinalityEnum**](#CardinalityEnum) |  |  [optional] |
|**createdAt** | **OffsetDateTime** |  |  [optional] |
|**updatedAt** | **OffsetDateTime** |  |  [optional] |
|**version** | **Long** |  |  [optional] |



## Enum: CardinalityEnum

| Name | Value |
|---- | -----|
| ONE_TO_ONE | &quot;ONE_TO_ONE&quot; |
| ONE_TO_MANY | &quot;ONE_TO_MANY&quot; |
| MANY_TO_ONE | &quot;MANY_TO_ONE&quot; |
| MANY_TO_MANY | &quot;MANY_TO_MANY&quot; |



