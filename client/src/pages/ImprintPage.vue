<template>
  <ion-page>
    <ion-content>
      <div class="container">
        <!-- Firmenwortlaut -->
        <p>
          <center><CompanyName /></center>
        </p>
        <!-- Rechtsform -->
        <div>
          <center>Gesellschaft mit beschränkter Haftung</center>
        </div>
        <!-- Unternehmensgegenstand -->
        <div>
          <center>Tourismus</center>
        </div>
        <p />
        <!-- UID-Nummer -->
        <div>
          <center>UID-Nr.: <UIDNumber /></center>
        </div>
        <!-- Firmenbuchnummer -->
        <div>
          <center>FB-Nr.: <FBNumber /></center>
        </div>
        <!-- Firmenbuchgericht -->
        <div>
          <center>FB-Gericht.: Handelsgericht Wien</center>
        </div>
        <!-- Firmensitz -->
        <div>
          <center>Firmensitz: <AddressComponent /></center>
        </div>
        <p />
        <!-- Telefon -->
        <div>
          <center>Tel.: <PhoneComponent /></center>
        </div>
        <!-- Email -->
        <div>
          <center>
            E-Mail:<a href="mailto:office@hotel-technikum.com"
              ><MailComponent
            /></a>
          </center>
        </div>
        <p />
        <!-- Mitgliedschaften bei WK Organisationen -->
        <div>
          <center>WKÖ, WK Wien</center>
        </div>
        <!-- anwendbare Rechtsvorschriften und Zugang dazu -->
        <div>
          <center>
            Rechtsvorschriften:&nbsp;<a href="https://www.ris.bka.gv.at"
              >www.ris.bka.gv.at</a
            >
          </center>
        </div>
        <!-- Aufsichtsbehörde -->
        <div>
          <center>Magistrat der Stadt Wien</center>
        </div>
        <p />
      </div>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonContent } from "@ionic/vue";
import {
  CompanyName,
  AddressComponent,
  PhoneComponent,
  MailComponent,
  FBNumber,
  UIDNumber,
} from "@/assets";

export default {
  name: "ImprintPage",
  components: {
    IonPage,
    IonContent,
    CompanyName,
    AddressComponent,
    PhoneComponent,
    MailComponent,
    FBNumber,
    UIDNumber,
  },
};
</script>

<style scoped></style>
