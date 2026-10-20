# ACM certificates (CloudFront)

CloudFront custom domains need an ACM certificate in **`us-east-1`** (not `eu-north-1`).

## Hostnames

| Env | Domain | Tag suggestion |
|-----|--------|----------------|
| stg | `netrunner-stg.7oas7er.com` | `Project=netrunner`, `Environment=stg` |
| prod | `netrunner.7oas7er.com` | `Project=netrunner`, `Environment=prod` |

## Create + DNS validate

```bash
export AWS_PROFILE=7oas7er

aws acm request-certificate \
  --region us-east-1 \
  --domain-name netrunner-stg.7oas7er.com \
  --validation-method DNS \
  --tags Key=Project,Value=netrunner Key=Environment,Value=stg \
  --query CertificateArn --output text

# Print the CNAME ACM needs (add this in Cloudflare DNS for zone 7oas7er.com):
aws acm describe-certificate --region us-east-1 --certificate-arn "$CERT_ARN" \
  --query 'Certificate.DomainValidationOptions[0].ResourceRecord' --output table
```

In Cloudflare → DNS → Add record:

- Type: **CNAME**
- Name: the `_….netrunner-stg` host (Cloudflare may show it without the zone suffix)
- Target: the `acm-validations.aws` value (proxy **DNS only** / grey cloud)
- TTL: Auto

Wait until status is `ISSUED`:

```bash
aws acm describe-certificate --region us-east-1 --certificate-arn "$CERT_ARN" \
  --query 'Certificate.Status' --output text
```

Put the ARN in `infra/terraform/aws/envs/stg/terraform.tfvars` as `site_certificate_arn` (never commit that file). Then `terraform apply` in `envs/stg`.

Repeat for `netrunner.7oas7er.com` before prod apply.
