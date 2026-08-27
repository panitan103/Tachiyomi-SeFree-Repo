package eu.kanade.tachiyomi.extension.th.niceoppai

import kotlin.Long
import kotlin.String

internal class ExtensionGenerated : Niceoppai() {
  protected override val filterFetchHint: String
    get() = "Tap 'Reset' to load filters"

  override val name: String
    get() = "Niceoppai"

  override val lang: String
    get() = "th"

  override val id: Long
    get() = 7_720_269_837_249_664_423L

  override val baseUrl: String
    get() = "https://www.niceoppai.net"
}
