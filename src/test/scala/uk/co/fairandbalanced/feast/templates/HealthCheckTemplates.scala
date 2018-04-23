package uk.co.fairandbalanced.feast.templates

import uk.co.fairandbalanced.feast.domain.healthcheck._

object HealthCheckTemplates {

  def HCTranslation(locale: String = "fr_FR",
                    content: String = "Nous sommes conscients du problème à cause duquel il est impossible de se connecter, et nous travaillons à le résoudre.",
                    heading: String = "Problèmes de connexion"
                   ): HCTranslation = HCTranslation(locale, content, heading)

  def HCMessage(severity: String = "warn",
                author: String = "test",
                id: Long = 0,
                created_at: String = "test",
                updated_at: String = "test",
                translations: List[HCTranslation] = List(HCTranslation()),
                content: String = "test"
               ): HCMessage = HCMessage(severity, author, id, created_at, updated_at, translations, content)

  def HCIncident(active: Boolean = false,
                 created_at: String = "test",
                 id: Long = 0,
                 updates: List[HCMessage] = List(HCMessage())
                ): HCIncident = HCIncident(active, created_at, id, updates)

  def HCService(status: String = "test",
                incidents: List[HCIncident] = List(HCIncident()),
                name: String = "test",
                slug: String = "test"
               ): HCService = HCService(status, incidents, name, slug)

  def HCBody(name: String = "test",
             region_tag: String = "test",
             hostname: String = "test",
             services: List[HCService] = List(HCService()),
             slug: String = "test",
             locales: List[String] = List("test")
            ): HCBody = HCBody(name, region_tag, hostname, services, slug, locales)

}