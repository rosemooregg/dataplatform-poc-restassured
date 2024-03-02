Feature: Validate time zone handling in data ingestion and transformation

Scenario: Verify time zone handling during data ingestion and transformation
  Given the data is ingested with a timestamp
  When the data is transformed
  Then the timestamp is correctly handled in the transformed data

Scenario: Verify time zone handling for different time zones
  Given the data is ingested with a timestamp in "UTC"
  When the data is transformed to "PST"
  Then the timestamp is correctly converted to "PST" in the transformed data

Scenario: Verify time zone handling for daylight saving time
  Given the data is ingested with a timestamp in "EST"
  When the data is transformed to "CST"
  Then the timestamp is correctly adjusted for daylight saving time in the transformed data

Scenario: Verify time zone handling for invalid time zones
  Given the data is ingested with a timestamp in an invalid time zone
  When the data is transformed
  Then an error is thrown indicating an invalid time zone

