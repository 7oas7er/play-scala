# Bootstrap — Terraform state bucket

Creates `shared-netrunner-terraform-state-bucket` (and related settings). Other roots store state **in** that bucket, so the first bootstrap apply cannot use the S3 backend yet.

## First apply (chicken-and-egg)

```bash
export AWS_PROFILE=7oas7er
cd infra/terraform/aws/bootstrap
cp terraform.tfvars.example terraform.tfvars   # optional; defaults are fine

# 1) Init providers only — do not configure the S3 backend yet
terraform init -backend=false

# 2) Create the bucket (state is written locally as terraform.tfstate)
terraform apply

# 3) Move local state into the new bucket (key: bootstrap/terraform.tfstate)
terraform init -migrate-state
# Answer yes when prompted to copy existing state to the new backend
```

After step 3, delete any leftover local `terraform.tfstate*` once you confirm `terraform state list` still shows the bucket resources.

## Later changes

```bash
export AWS_PROFILE=7oas7er
cd infra/terraform/aws/bootstrap
terraform init
terraform plan
terraform apply
```

Do **not** destroy this bucket while other roots still use it as a backend.
