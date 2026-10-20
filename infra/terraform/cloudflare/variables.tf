variable "zone_id" {
  description = <<-EOT
    Cloudflare zone id for 7oas7er.com (dashboard Zone ID / GitHub CLOUDFLARE_ZONE_ID).
    Prefer this over data.cloudflare_zones: the list data source embeds deprecated
    plan/permissions fields that spam terraform plan warnings.
  EOT
  type        = string
  default     = "701810fff825f90c0eea671970a0cc9e"
}

variable "prod_cloudfront_domain_name" {
  description = "CloudFront domain name for production (netrunner.7oas7er.com), such as d111111abcdef8.cloudfront.net."
  type        = string
}

variable "stg_cloudfront_domain_name" {
  description = "CloudFront domain name for staging (netrunner-stg.7oas7er.com), such as d111111abcdef8.cloudfront.net."
  type        = string
}

variable "stg_origin_verify_secret" {
  description = "Secret Cloudflare sets as X-Origin-Verify for staging; must match envs/stg origin_verify_secret."
  type        = string
  sensitive   = true
}

variable "prod_origin_verify_secret" {
  description = "Secret Cloudflare sets as X-Origin-Verify for production; must match envs/prod origin_verify_secret."
  type        = string
  sensitive   = true
}
