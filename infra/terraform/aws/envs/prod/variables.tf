variable "environment" {
  description = "Short environment name used in resource names and tags."
  type        = string
  default     = "prod"
}

variable "aws_region" {
  description = "Region of the Netrunner resources (S3, supporting IAM)."
  type        = string
  default     = "eu-north-1"
}

variable "aws_profile" {
  description = "Optional AWS shared-credentials profile for local use. Leave null in CI (use the default credential chain / OIDC)."
  type        = string
  default     = null
  nullable    = true
}

variable "site_domain_name" {
  description = "Custom domain attached to the CloudFront distribution."
  type        = string
  default     = "netrunner.7oas7er.com"
}

variable "site_certificate_arn" {
  description = "ACM certificate in us-east-1 for the production hostname (netrunner.7oas7er.com)."
  type        = string
}

variable "github_actions_subject" {
  description = "GitHub Actions OIDC subject for the production GitHub Environment (jobs with environment: production). Confirm via CloudTrail if assume fails."
  type        = string
  # play-scala tokens use the classic sub (no @ownerId/@repoId); block-drop uses the ID form.
  default = "repo:7oas7er/play-scala:environment:production"
}

variable "origin_verify_secret" {
  description = "Shared secret Cloudflare injects as X-Origin-Verify for production; must match Cloudflare prod_origin_verify_secret."
  type        = string
  sensitive   = true
}

variable "origin_verify_secret_previous" {
  description = "Optional previous production origin-verify secret during rotation. See docs/origin-verify-secret-rotation.md."
  type        = string
  sensitive   = true
  default     = null
  nullable    = true
}
