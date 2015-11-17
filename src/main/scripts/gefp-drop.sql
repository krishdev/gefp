
    alter table CombinationTable 
        drop constraint FK_46ivpv8mfpjwt1mjqlkex5v4n;

    alter table CombinationTable 
        drop constraint FK_reeyjvokpuotfegs8hyiaqfm5;

    alter table CombinationTable 
        drop constraint FK_q4cko6i1cjrnqwj5g3owghaay;

    alter table CombinationTable 
        drop constraint FK_9sm8qffm2edcfpdvmx2iphqm5;

    alter table Departmentdetails 
        drop constraint FK_3spv7q3cmmpl36ew70y0k0p44;

    alter table Users 
        drop constraint FK_hnqu9mlwl3xtmrx30miy8efb8;

    alter table Users 
        drop constraint FK_tepjub63jf9ay1mot9lq4m1fh;

    alter table authorities 
        drop constraint FK_s21btj9mlob1djhm3amivbe5e;

    alter table departmentdetails_flightplandetails 
        drop constraint FK_6rfdy4axhpe00simpt2q7u33g;

    alter table departmentdetails_flightplandetails 
        drop constraint FK_65kcd6ehwhqp2d59x5vdp56c5;

    alter table fprunway 
        drop constraint FK_m6ibko0bu808sjnauvtq9ht8c;

    alter table fprunway 
        drop constraint FK_khxqvm8vwqgpo5e6010ybgf7w;

    alter table fpstage 
        drop constraint FK_gryesa806kw989j843ffvl6ns;

    alter table fpstage 
        drop constraint FK_hxowccu6q98s58ay0h9rp9q0f;

    alter table user_chkpt 
        drop constraint FK_qwn7y4308a46igkv45mmxt5c5;

    alter table user_chkpt 
        drop constraint FK_h72r7r2ekt7f6vmsvn8kykm73;

    drop table if exists ChkPtDetails cascade;

    drop table if exists CombinationTable cascade;

    drop table if exists Departmentdetails cascade;

    drop table if exists FlightPlanDetails cascade;

    drop table if exists RunwayDetails cascade;

    drop table if exists StageDetails cascade;

    drop table if exists Users cascade;

    drop table if exists authorities cascade;

    drop table if exists departmentdetails_flightplandetails cascade;

    drop table if exists fprunway cascade;

    drop table if exists fpstage cascade;

    drop table if exists user_chkpt cascade;

    drop sequence hibernate_sequence;
