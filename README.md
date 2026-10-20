# Lab 6: Navigation Practical 2 (Lifecycles and Fragments)

**Name:** <your name>
**Reg No:** 192194
**Unit:** BBT 3.2 Mobile Application Development (Kotlin)

## What this project contains
- LoginActivity and RegisterActivity (moving with Intents)
- MainActivity with the Add Tenant form, Data Binding, and an implicit Intent for CALL TENANT
- Activity lifecycle logging in LoginActivity, RegisterActivity and MainActivity (tag `TENANT_LIFECYCLE`)
- State saving across rotation with onSaveInstanceState and a Bundle (tenant and save counter)
- Tenant (Serializable) and TenantRepository (object)
- DashboardFragment, AddTenantFragment, ViewTenantsFragment with full Fragment lifecycle logging
- Navigation Graph (nav_graph.xml) connecting the three Fragments, with Safe Args

## Note
The Fragments are not displayed yet. They are plugged into MainActivity with a NavHost in Practical 3,
so their lifecycle logs appear only after that.

## Logcat screenshots
*(Screenshots saved in the `screenshots/` folder)*
