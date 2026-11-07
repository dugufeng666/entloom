

# OntologyPropertyResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  [optional] |
|**ontologyId** | **UUID** |  |  [optional] |
|**classId** | **UUID** |  |  [optional] |
|**name** | **String** |  |  [optional] |
|**description** | **String** |  |  [optional] |
|**valueType** | [**ValueTypeEnum**](#ValueTypeEnum) |  |  [optional] |
|**required** | **Boolean** |  |  [optional] |
|**createdAt** | **OffsetDateTime** |  |  [optional] |
|**updatedAt** | **OffsetDateTime** |  |  [optional] |
|**version** | **Long** |  |  [optional] |



## Enum: ValueTypeEnum

| Name | Value |
|---- | -----|
| TEXT | &quot;TEXT&quot; |
| NUMBER | &quot;NUMBER&quot; |
| BOOLEAN | &quot;BOOLEAN&quot; |
| DATE | &quot;DATE&quot; |
| REFERENCE | &quot;REFERENCE&quot; |



