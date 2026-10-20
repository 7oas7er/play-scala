locals {
  # Naming: [environment]-netrunner-[purpose]-[resource-type]
  name_prefix = "${var.environment}-netrunner"

  site_bucket_name                  = "${local.name_prefix}-site-bucket"
  access_logs_bucket_name           = "${local.name_prefix}-access-logs-bucket"
  cloudfront_log_delivery_name      = "${local.name_prefix}-cloudfront-access-logs"
  cloudfront_5xx_alarm_name         = "${local.name_prefix}-site-5xx-alarm"
  github_deploy_role_name           = "${local.name_prefix}-github-deploy-role"
  github_deploy_policy_name         = "${local.name_prefix}-github-deploy-policy"
  site_oac_name                     = "${local.name_prefix}-site-oac"
  site_origin_id                    = "${local.name_prefix}-site-origin"
  site_distribution_name            = "${local.name_prefix}-site-distribution"
  origin_verify_function_name       = "${local.name_prefix}-origin-verify-function"
  site_response_headers_policy_name = "${local.name_prefix}-security-headers-policy"
  cache_policy_caching_optimized    = "658327ea-f89d-4fab-a63d-7e88639e58f6"
  # Static catalog: same-origin JS/JSON; Google Fonts for display type (no API).
  content_security_policy = join("; ", [
    "default-src 'self'",
    "script-src 'self'",
    "style-src 'self' https://fonts.googleapis.com",
    "img-src 'self'",
    "font-src 'self' https://fonts.gstatic.com",
    "connect-src 'self'",
    "object-src 'none'",
    "base-uri 'self'",
    "form-action 'self'",
    "frame-ancestors 'self'",
    "upgrade-insecure-requests",
  ])
  # Catalog does not use camera/mic/geo/payment; keep Permissions-Policy tight.
  permissions_policy = join(", ", [
    "accelerometer=()",
    "camera=()",
    "geolocation=()",
    "gyroscope=()",
    "magnetometer=()",
    "microphone=()",
    "payment=()",
    "usb=()",
    "interest-cohort=()",
  ])
}
