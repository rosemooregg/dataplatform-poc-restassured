import boto3
import yaml

# Initialize Boto3 AWS Glue client
glue_client = boto3.client('glue')
import boto3

session = boto3.Session(
    aws_access_key_id='YOUR_ACCESS_KEY',
    aws_secret_access_key='YOUR_SECRET_KEY',
    region_name='YOUR_REGION'
)
# Get list of all databases in Glue
databases_response = glue_client.get_databases()

# Initialize dictionary to store database and table information
data_sets = {}

# Iterate over each database
for database in databases_response['DatabaseList']:
    database_name = database['Name']
    tables_response = glue_client.get_tables(DatabaseName=database_name)

    # Initialize list to store table names for each database
    table_names = []

    # Iterate over each table in the database
    for table in tables_response['TableList']:
        table_names.append(table['Name'])

    # Add database and table information to dictionary
    data_sets[database_name] = table_names

# Write dictionary to YAML file
with open('data_sets.yaml', 'w') as file:
    yaml.dump(data_sets, file, default_flow_style=False)
