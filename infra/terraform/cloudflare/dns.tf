resource "cloudflare_dns_record" "netrunner" {
  zone_id = local.zone_id
  name    = "netrunner.7oas7er.com"
  type    = "CNAME"
  content = var.prod_cloudfront_domain_name
  proxied = true
  ttl     = 1
}

resource "cloudflare_dns_record" "netrunner_stg" {
  zone_id = local.zone_id
  name    = "netrunner-stg.7oas7er.com"
  type    = "CNAME"
  content = var.stg_cloudfront_domain_name
  proxied = true
  ttl     = 1
}
