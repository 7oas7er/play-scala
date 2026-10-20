# Bootstrap — Terraform state bucket

Creates `shared-netrunner-terraform-state-bucket` (versioned, encrypted, private). All **other** Terraform roots store remote state in that bucket.

This root uses a **local** backend (`terraform.tfstate`, gitignored). That avoids the chicken-and-egg where an S3 backend cannot initialize before the bucket exists.

## First apply

```bash
export AWS_PROFILE=7oas7er
cd infra/terraform/aws/bootstrap
cp terraform.tfvars.example terraform.tfvars   # optional; defaults are fine

terraform init
terraform apply
```

If you previously ran `terraform init` while this root still declared an S3 backend, clear the stale backend config and re-init:

```bash
rm -rf .terraform
terraform init -reconfigure
terraform apply
```

## Later changes

```bash
export AWS_PROFILE=7oas7er
cd infra/terraform/aws/bootstrap
terraform init
terraform plan
terraform apply
```

Do **not** destroy this bucket while other roots still use it as a backend. Keep a backup of `terraform.tfstate` somewhere safe (not git) if you care about recovering bootstrap ownership without `terraform import`.
