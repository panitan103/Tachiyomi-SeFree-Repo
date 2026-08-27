# SeFree — Niceoppai extension (Mihon)

Personal Mihon extension source for **https://www.niceoppai.net** (Thai manga, current
"NOPOrange" theme). Built on the Keiyoushi extension framework (`KeiSource`, lib 1.6).

## What's where
- `src/th/niceoppai/` — the Kotlin source (single module, package `eu.kanade.tachiyomi.extension.th.niceoppai`)
- `core/`, `compiler/`, `common/`, `gradle/` — the Keiyoushi build skeleton this module needs
- Branch `repo` — the generated Mihon store (`index.pb`, `index.min.json`, `index.json`, APK)

## Rebuild
```bash
export ANDROID_HOME=/path/to/android-sdk
export JAVA_HOME=/path/to/jdk17
./gradlew src:th:niceoppai:assembleRelease
```
APK + `keiyoushi-source-info.json` land in `src/th/niceoppai/build/`.

## Add to Mihon
Settings → Browse → Extension repos → Add:
```
https://gitea.sefree-media.net/sefree/Tachiyomi-SeFree-Repo/raw/branch/repo/index.pb
```
(requires Mihon 0.20.4+)

## Notes / limitations
- **Search** uses the GET route `/manga_list/search/<query>/<order>/<page>/`.
  The site's POST search endpoint is Cloudflare-gated, so it is not used.
- **Popular** = `/manga_list/all/any/most-popular/N`, **Latest** = `/manga_list/all/any/last-updated/N`.
- Chapters paginate via `/chapter-list/N/`; page images are served from `https://image*.niceoppai.net`.
- `contentWarning` = MIXED (site hosts adult titles. Set to `ContentWarning.NSFW` in the module
  `build.gradle.kts` if you want it strict-only).
- To bump the version, increment `versionCode` in `src/th/niceoppai/build.gradle.kts`, rebuild,
  and re-run the store generator (`/tmp/gen_repo.py`) to refresh `index.pb` before pushing `repo`.
