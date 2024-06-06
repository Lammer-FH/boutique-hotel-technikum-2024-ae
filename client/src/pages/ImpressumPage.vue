<template>
    <ion-page>
      <ion-content>
        <!-- Firmenwortlaut -->
        <div>
            <center>Boutique-Hotel Technikum GmbH</center>
        </div>
        <!-- Rechtsform -->
        <div>
            <center>Gesellschaft mit beschränkter Haftung</center>
        </div>
        <!-- Unternehmensgegenstand -->
        <div>
            <center>Tourismus</center>
        </div>
        <p/>
        <!-- UID-Nummer -->
        <div>
            <center>UID-Nr.: ATU12345678</center>
        </div>
        <!-- Firmenbuchnummer -->
        <div>
            <center>FB-Nr.: 123456 a</center>
        </div>
        <!-- Firmenbuchgericht -->
        <div>
            <center>FB-Gericht.: Handelsgericht Wien</center>
        </div>
        <!-- Firmensitz -->
        <div>
            <center>Firmensitz: Höchstädtplatz 6, 1200 Vienna, Austria></center>
        </div>
        <p/>
        <!-- Telefon -->
        <div>
            <center>Tel.: <Phone /></center>
        </div>
        <!-- Email -->
        <div>
            <center>E-Mail:&nbsp;<a href=mailto:office@hotel-technikum.com><Email /></a></center>
        </div>
        <p/>
        <!-- Mitgliedschaften bei WK Organisationen -->
        <div>
            <center>WKÖ, WK Wien</center>
        </div>
        <!-- anwendbare Rechtsvorschriften und Zugang dazu -->
        <div>
            <center>Rechtsvorschriften:&nbsp;<a href="https://www.ris.bka.gv.at">www.ris.bka.gv.at</a></center>
        </div>
        <!-- Aufsichtsbehörde -->
        <div>
            <center>Magistrat der Stadt Wien</center>
        </div>
        <p/>
      </ion-content>
    </ion-page>
  </template>
  
  <script>
  import { IonPage, IonContent } from '@ionic/vue';
  
  export default {
    name: 'ImpressumPage',
    components: {
      IonPage,
      IonContent,
    },
  };
  </script>
  
  <style scoped>
  </style>